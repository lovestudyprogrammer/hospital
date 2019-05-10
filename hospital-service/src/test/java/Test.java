import com.hospital.utils.DateUtil;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        String format = DateUtil.CUSTOM_DAY_FORMATOR.format(new Date());
        System.out.println(format);
    }
}
