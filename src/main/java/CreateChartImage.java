import grails.util.GrailsUtil;
import grails.web.context.ServletContextHolder;

public class CreateChartImage {

    public static void main(String arr[]) {
        CreateChartImage chartImage = new CreateChartImage();
        System.out.println(chartImage.path());
    }

    String path() {
        String path = "";
        if (GrailsUtil.isDevelopmentEnv()) {
            path = ServletContextHolder.getServletContext().getRealPath("/");
        } else {
            path = "/mnt/uploadedFiles/";
        }
        return path;
    }
}
