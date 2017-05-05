import java.lang.reflect.Modifier;

/**
 * Created by Yelyzaveta_Horbachen on 03.05.17.
 */
public final class Methods {
    public static boolean isInteger(String s) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),10) < 0) return false;
        }
        return true;
    }

    public static String getModifiers(int m) {
        StringBuilder modifiers = new StringBuilder();
        if (Modifier.isPublic(m)) modifiers.append("public ");
        if (Modifier.isProtected(m)) modifiers.append("protected ");
        if (Modifier.isPrivate(m)) modifiers.append("private ");
        if (Modifier.isStatic(m)) modifiers.append("static ");
        if (Modifier.isAbstract(m)) modifiers.append("abstract ");
        return modifiers.toString();
    }
}
