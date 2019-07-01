package dummy;

public class InstagramClient {

    private String accountId;

    public InstagramClient(String accountId){
        this.accountId = accountId;
    }

    public boolean isHasAccountId(){
        return accountId != null;
    }

    public String getAccountId(){
        return accountId;
    }

    public IgStory createStory(String accountId){
        IgStory story = new IgStory();
        story.setId("storyId_" + accountId);
        return story;
    }
}
