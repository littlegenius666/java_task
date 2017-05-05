/**
 * Created by Yelyzaveta_Horbachen on 03.05.17.
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) throws Exception{
        View view=new View();
        Class clazz = Class.forName("Rectangle");
        Object entity = clazz.getConstructor(int.class, int.class,View.class,int.class,int.class).newInstance(0,0,view,2,3);
        view.print("Class name: "+clazz.getName());
        view.print("Superclass name: "+clazz.getSuperclass().getName());
        view.print("Fields in "+clazz.getName()+":");
        for (Field field: clazz.getDeclaredFields()
                ) {
            view.print("    "+Methods.getModifiers(field.getModifiers())+field.getType()+" "+field.getName());
        }
        view.print("Fields in "+clazz.getSuperclass().getName()+":");
        for (Field field: clazz.getSuperclass().getDeclaredFields()
                ) {
            view.print("    "+Methods.getModifiers(field.getModifiers())+field.getType()+" "+field.getName());
        }
        view.print("List of annotations:");
        List<String> uniqueAnnotations=new ArrayList<String>();
        for (Method m: clazz.getMethods()
             ) {
            for (Annotation ann: m.getAnnotations()
                 ) {
                if (!uniqueAnnotations.contains(ann.annotationType().toString()))
                uniqueAnnotations.add(ann.annotationType().toString());
            }
        }
        for (String ann:uniqueAnnotations
             ) {
            view.print("    "+ann);
        }
        System.out.println("---------------------------------------------");
        for(Method method : clazz.getMethods()){
            if( method.isAnnotationPresent( getValue.class )){
                view.print(method.getName()+": "+method.invoke(entity).toString());
            }
        }
        System.out.println("---------------------------------------------");
        IRectangle rect=new RectangleProxy();
        try {
            view.print(Integer.toString(rect.getHeight()));
            rect.setHeight(22);
        } catch (UnsupportedOperationException e) {
            System.err.println(e.getMessage());
        }
    }

}
