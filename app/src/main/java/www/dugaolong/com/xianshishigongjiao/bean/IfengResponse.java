package www.dugaolong.com.xianshishigongjiao.bean;

/**
 * Created by dugaolong on 17/8/17.
 */

public class IfengResponse {
    private boolean success;
    private String  channelName;
    private String  channelType;
    private String  id;
    private IFengData  data;

    public IfengResponse() {
    }

    public IfengResponse(boolean success, String channelName, String channelType, String id, IFengData data) {
        this.success = success;
        this.channelName = channelName;
        this.channelType = channelType;
        this.id = id;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IFengData getData() {
        return data;
    }

    public void setData(IFengData data) {
        this.data = data;
    }
}
