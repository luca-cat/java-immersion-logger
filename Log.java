
public class Log {
    String mediaType;
    String contentName;

    public Log(String mediaType, String contentName){
        this.mediaType = mediaType;
        this.contentName = contentName;
    }

    public static String getMediaType(String mediaType){
        return mediaType;
    }

    public static String getContentName(String contentName){
        return contentName;
    }

    @Override 
    public String toString(){
        return mediaType + ":" + contentName;
    }
}
