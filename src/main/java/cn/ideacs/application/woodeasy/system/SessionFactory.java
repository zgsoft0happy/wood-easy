package cn.ideacs.application.woodeasy.system;

import cn.ideacs.application.woodeasy.entity.account.Account;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author yang
 * @date 18-5-22 下午4:19
 */
public class SessionFactory {

    private static final String USERID = "id";
    private static final String USERNAME = "username";
    private static final String SHOWNAME = "showName";

    /**
     * 获得httpRequest
     * @return
     */
    public static HttpServletRequest getRequest() {
        if (RequestContextHolder.getRequestAttributes() == null) {
            return null;
        }
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获得HttpResponse
     * @return
     */
    public static HttpServletResponse getResponse() {
        if (RequestContextHolder.getRequestAttributes() == null) {
            return null;
        }
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public static HttpSession getSession() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return null;
        }
        return request.getSession();
    }

    public static void createSession(Account account) {
        HttpSession session = getSession();
        if (session == null) {
            return;
        }
        session.setAttribute(USERID, account.getId());
        session.setAttribute(USERNAME, account.getUsername());
        session.setAttribute(SHOWNAME, account.getShowName());
    }

    public static Long getUserId(){
        Object userId = getSession().getAttribute(USERID);
        if (userId == null) {
            return 0l;
        } else {
            return Long.parseLong(userId.toString());
        }
    }

    public static String getUsername() {
        Object username = getSession().getAttribute(USERNAME);
        if (username == null) {
            return "";
        } else {
            return username.toString();
        }
    }

    public static String getShowName() {
        Object showName = getSession().getAttribute(SHOWNAME);
        if (showName == null) {
            return "";
        } else {
            return showName.toString();
        }
    }

}
