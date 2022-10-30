
package trongtoan.entity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import trongtoan.dao.DAO;

public class TrongToan {
    public static void sendEmail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String subject = "Your order has been processing.";
        String message = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "\n"
                + "<head>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <h3 style=\"color: blue;\">Your order has been processing.</h3>\n"
                + "    <div>Full Name :" + request.getParameter("fullNameEmail") + "</div>\n"
                + "    <div>ToTal Order :" + request.getParameter("total") + " VND" + "</div>\n"
                + "    <div>address : " + request.getParameter("address") + " </div>\n"
                + "    <div>city : " + request.getParameter("city") + " </div>\n"
                + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                + "\n"
                + "</body>\n"
                + "\n"
                + "</html>";
        sendEmail.send(request.getParameter("email"), subject, message, "toanntse161325@fpt.edu.vn", "nguyentrongtoan");
    }

    public static String oID() throws SQLException {
        String chu = null;
        int so = 1;
        String rIDD = null;
        int pos = 0;
        DAO dao = new DAO();
        //Function For tăng tự động orderID để người dùng đỡ phải nhập tay nha thầy !!
        do {
            if (so < 10) {

                chu = "Or00";
                rIDD = chu + so;
                pos = dao.checkOrID(rIDD);
                if (pos == 1) {
                    so++;
                }
            }
            if (so >= 10) {
                chu = "Or0";
                rIDD = chu + so;
                pos = dao.checkOrID(rIDD);
                if (pos == 1) {
                    so++;
                }
            }
            if (so >= 100) {
                chu = "Or";
                rIDD = chu + so;
                pos = dao.checkOrID(rIDD);
                if (pos == 1) {
                    so++;
                }
            }

        } while (pos != -1);
        return rIDD;
    }
    public static String pID() throws SQLException {
        int so = 1;
        int pos = 0;
        String rID ; 
        DAO dao = new DAO();
        //Function For tăng tự động Product ID để người dùng đỡ phải nhập tay nha thầy !!
        do {
                pos = dao.checkpID(so);
                rID = "" + so ; 
                if (pos == 1) {
                    so++;
                }
                
        } while (pos != -1);
        return rID;
    }

    public static String dID() throws SQLException {
        String chu = null;
        int so = 1;
        String rIDD = null;
        int pos = 0;
        DAO dao = new DAO();
        //Function For tăng tự động detailID để người dùng đỡ phải nhập tay nha thầy !!
        do {
            if (so < 10) {

                chu = "D00";
                rIDD = chu + so;
                pos = dao.checkDID(rIDD);
                if (pos == 1) {
                    so++;
                }
            }
            if (so >= 10) {
                chu = "D0";
                rIDD = chu + so;
                pos = dao.checkDID(rIDD);
                if (pos == 1) {
                    so++;
                }
            }
            if (so >= 100) {
                chu = "D";
                rIDD = chu + so;
                pos = dao.checkDID(rIDD);
                if (pos == 1) {
                    so++;
                }
            }

        } while (pos != -1);
        return rIDD;
    }
    public static String aID(String x) throws SQLException {
        String chu = null;
        int so = 1;
        String aIDD = null;
        int pos = 0;
        DAO dao = new DAO();
        //Function For tăng tự động account rID để người dùng đỡ phải nhập tay nha thầy!!

        if("AD".equals(x) ) {
            do {
            if (so < 10) {

                chu = "A0";
                aIDD = chu + so;
                pos = dao.checkAID(aIDD);
                if (pos == 1) {
                    so++;
                }
            }
            if (so >= 10) {
                chu = "A";
                aIDD = chu + so;
                pos = dao.checkAID(aIDD);
                if (pos == 1) {
                    so++;
                }
            }
        } while (pos != -1);
        } else if ("SEL".equals(x)) {
            do {
            if (so < 10) {

                chu = "S0";
                aIDD = chu + so;
                pos = dao.checkAID(aIDD);
                if (pos == 1) {
                    so++;
                }
            }
            if (so >= 10) {
                chu = "S";
                aIDD = chu + so;
                pos = dao.checkAID(aIDD);
                if (pos == 1) {
                    so++;
                }
            }
        } while (pos != -1);
        } else if ("US".equals(x)) {
            do {
            if (so < 10) {

                chu = "U0";
                aIDD = chu + so;
                pos = dao.checkAID(aIDD);
                if (pos == 1) {
                    so++;
                }
            }
            if (so >= 10) {
                chu = "U";
                aIDD = chu + so;
                pos = dao.checkAID(aIDD);
                if (pos == 1) {
                    so++;
                }
            }
        } while (pos != -1);
        }
        return aIDD;
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static LoginGoogleDTO getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        LoginGoogleDTO googlePojo = new Gson().fromJson(response, LoginGoogleDTO.class);

        return googlePojo;
    }
}
