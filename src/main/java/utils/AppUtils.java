package utils;

import model.beans.Cart;
import model.beans.Product;
import model.beans.User;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;

public class AppUtils {

    public static final String attributeUser = "userInfo";

    public static final String attributeCatalog = "productCatalog";

    public static void storeLoginedUser(HttpSession session, User user, Cart cart) {
        session.setAttribute(attributeUser, user);
        CartUtils.storeCart(session,cart);
    }

    public static void storeLoginedUserInfo(HttpSession session, User user) {
        session.setAttribute(attributeUser, user);
    }

    public static User getLoginedUser (HttpSession session) {
        return  (User) session.getAttribute(attributeUser);
    }

    public static void removeLoginedUser (HttpSession session) {

        var Iterator = session.getAttributeNames().asIterator();

        while (Iterator.hasNext()) {
            session.removeAttribute(Iterator.next());

        }

        var asd = session.getAttributeNames();

    }

    public static void storeCatalog(HttpSession session, LinkedHashMap<? extends Product, String> productList) {
        session.setAttribute(attributeCatalog, productList);
    }


    public static LinkedHashMap<? extends Product, String> getCatalog (HttpSession session) {
        return (LinkedHashMap<? extends Product, String>) session.getAttribute(attributeCatalog);
    }


    public static void removeCatalog (HttpSession session) {
        session.removeAttribute(attributeCatalog);
    }

    public static boolean catalogIsExist (HttpSession session) {

        return session.getAttribute(attributeCatalog) != null;
    }






}
