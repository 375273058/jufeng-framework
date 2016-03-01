package co.jufeng.web.context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import co.jufeng.core.logger.LoggerUtils;
import co.jufeng.web.servlet.bind.annotation.RestController;


public class LoadServletListener implements ServletContextListener{
    private static Map<String, Object> map = new HashMap<String, Object>();
    
    private String servletPackage;
    
    private Object view;
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if(map != null){
        	map = null;
        }
    }
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        servletPackage = context.getInitParameter("controllerPackage");
        view = context.getInitParameter("view");
        String classPath = context.getRealPath("/WEB-INF/classes/" + servletPackage.replace('.', File.separatorChar));
        scanClassPath(new File(classPath));
        context.setAttribute("mapPath", map);
        context.setAttribute("view", view);
    }
     
    private void scanClassPath(File file) {
        try {
            if (file.isFile()) {
                if (file.getName().endsWith(".class")) {
                    String path = file.getPath();
                    MyClassLoader myClassLoader = new MyClassLoader(this.getClass().getClassLoader());
                    Class<?> clazz = myClassLoader.load(path);
                    RestController controller = (RestController) clazz.getAnnotation(RestController.class);
                    if (controller != null) {
                        String uri = controller.value();
                        Object action = clazz.newInstance();
                        if(uri.equals("")){
                        	String className = action.getClass().getSimpleName();
                        	String classPath = clazz.getName();  
                            String packageName = classPath.replace(servletPackage, "").replace("." + className, "").replace(".", "/");
                        	char[] chars = new char[1];  
                            chars[0] = className.charAt(0);  
                            String temp = new String(chars);  
                            if(chars[0] >= 'A'  &&  chars[0] <= 'Z') { 
                            	uri = className.replaceFirst(temp, temp.toLowerCase());
                            	uri = "/" + uri.replace("Controller", "");
                            	uri = packageName + uri;
                            }  
                        }
                        LoggerUtils.debug(getClass(), uri);
                        map.put(uri, action);
                    }
                }
            } else {
                File[] files = file.listFiles();
                for (File child : files) {
                    scanClassPath(child);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    class MyClassLoader extends ClassLoader {
        public MyClassLoader(ClassLoader parent) {
            super(parent);
        }
        public Class<?> load(String path) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(path);
                byte[] buf = new byte[fis.available()];
                int len = 0;
                int total = 0;
                int fileLength = buf.length;
                while (total < fileLength) {
                    len = fis.read(buf, total, fileLength - total);
                    total = total + len;
                }
                return super.defineClass(null, buf, 0, fileLength);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    fis = null;
                }
            }
        }
    }
}