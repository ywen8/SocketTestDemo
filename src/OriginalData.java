import java.io.Serializable;

public final class OriginalData implements Serializable {
    /**
     * 原始数据包头字节数组
     */
    private byte[] mHeadBytes;
    /**
     * 原始数据包体字节数组
     */
    private byte[] mBodyBytes;

    /**
     * 包体长度
     */
    private byte[] bodyLength;
    /**
     * 包尾
     */
    private byte[] mFootBytes;


    public byte[] getHeadBytes() {
        return mHeadBytes;
    }

    public void setHeadBytes(byte[] headBytes) {
        mHeadBytes = headBytes;
    }

    public byte[] getBodyBytes() {
        return mBodyBytes;
    }

    public void setBodyBytes(byte[] bodyBytes) {
        mBodyBytes = bodyBytes;
    }

    public byte[] getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(byte[] bodyLength) {
        this.bodyLength = bodyLength;
    }

    public byte[] getmFootBytes() {
        return mFootBytes;
    }

    public void setmFootBytes(byte[] mFootBytes) {
        this.mFootBytes = mFootBytes;
    }
}
