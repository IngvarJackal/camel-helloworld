package helloworld.camel.camel;

import org.apache.camel.CamelContext;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Set;

@Startup
@Singleton
public class EntrypointsService {
    public final static String API_PACKAGE = "helloworld.camel.services";

    @Inject
    private CamelContext camelContext;

    private ContextHolder contextHolder;

    public EntrypointsService() {} // for @Singleton

    private static HashMap<Class, Object> proxies = new HashMap<>();
    private static Reflections reflections = new Reflections(API_PACKAGE, new MethodAnnotationsScanner(), new SubTypesScanner());
    private static Set<Method> methods = reflections.getMethodsAnnotatedWith(ServiceEnrtypoint.class);

    @PostConstruct
    private void init() {
        try {
            for (Method method : methods) {
                // TODO init routes
            }
            this.contextHolder = new ContextHolder(camelContext);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public <T> T getProxy(Class<T> target) {
        proxies.computeIfAbsent(target, this::makeProxy);
        return (T) proxies.get(target);
    }

    @SuppressWarnings("unchecked")
    public <T> T makeProxy(Class<T> target) {
        Set<Class<? extends T>> classes = reflections.getSubTypesOf(target);
        if (classes.size() > 1) {
            throw new RuntimeException("Interface " + target.getName() + " is implemented in multiple classes: " + classes);
        } else if (classes.size() < 1) {
            throw new RuntimeException("Interface " + target.getName() + " isn't implemented in namespace " + API_PACKAGE);
        } else {
            for (Class<? extends T> c: classes) { // actually, will take first one
                System.out.println(c.getName());
                return (T) Proxy.newProxyInstance(
                        target.getClassLoader(),
                        new Class<?>[]{target},
                        new BeanInvocationHandler(c));
            }
            return null; // hack for compiler
        }
    }

    class BeanInvocationHandler implements InvocationHandler {
        private final Class iClass;
        BeanInvocationHandler(Class iClass) {
            this.iClass = iClass;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object impl = iClass.newInstance();
            Method implMethod = iClass.getMethod(method.getName(), method.getParameterTypes());
            return implMethod.invoke(impl, args);
        }
    }
}
