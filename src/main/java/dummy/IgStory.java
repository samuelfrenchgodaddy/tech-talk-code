package dummy;

public class IgStory {
    private String id;
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public Long postToStoryAndGetId(String message){
        return 99L;
    }
}
