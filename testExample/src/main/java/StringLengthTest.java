import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @program: cloudPay
 * @description:
 * @author: chenchen.mou
 * @create: 2021-07-14 11:11
 **/
public class StringLengthTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        StringBuilder message = new StringBuilder("9004"); // 短信交易码
        message.append("0001"); // 短信条数
        message.append("0"); // 报文子类型
        message.append("133xxxxxxxx         "); // 电话号
        StringBuilder content = new StringBuilder(); // 短信内容
        content.append("619200（财付通验证码，一分钟有效，请勿泄露），您尾号0087的银行卡正在开通财付通快捷支付");
        String contentLengthStr = String.format("%03d", content.toString().getBytes("GBK").length);
        System.out.println("contentLengthStr = " + contentLengthStr);
        message.append(contentLengthStr).append(content);
        message.append("0"); // 报文类型
        message.append("00000000000000"); // 发送时间
        message.append("                               "); // 客户账号 + 发送柜员
        System.out.println("message.toString() = " + message.toString());
        String messageLengthStr = String.format("%06d", message.toString().getBytes("GBK").length);
        System.out.println("messageLengthStr = " + messageLengthStr);
        StringBuilder sendMessage = new StringBuilder(messageLengthStr);
        sendMessage.append(message);
        System.out.println("sendMessage.toString() = " + sendMessage.toString());
        String format = DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN);
        System.out.println("format = " + format);
        System.out.println("format.length() = " + format.length());
        System.out.println("format.getBytes(\"GBK\").length = " + format.getBytes("GBK").length);
    }
}
