public class MsgBean {

    //指令
    private int cmd;
    //数据内容
    private String content;

    private int errcode;

    private String errmsg;
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    public int getErrcode() {
        return errcode;
    }

    @Override
    public String toString() {
        return "MsgBean{" +
                "cmd=" + cmd +
                ", content='" + content + '\'' +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getCmd() {
        return cmd;
    }


    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}



