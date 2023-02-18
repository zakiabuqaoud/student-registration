public class Operation {

    public static boolean isDate(String str) {
        return str.matches("[0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]");
    }

    public static boolean checkIsNotHash(String text){
        if( text.contains("#") || text.contains(":")){
            return false;
        }
        return true;

    }

    public static boolean isPhoneNumber(String str) {
        return str != null && str.matches("\\+?\\d*");
    }

}
