import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostToSocialMediaConditionalTest {


    private String aLongString = "this is a long string ";
    private PostToSocialMedia postToSocialMediaConditional = new PostToSocialMediaConditional();

    @Test
    void postToSocialMediaFacebook() {
        assert postToSocialMediaConditional.postToSocialMedia("facebook","abc").equals("workedOKFacebook");
        assert postToSocialMediaConditional.postToSocialMedia("facebook","1234d").equals("workedOKFacebook");
    }

    @Test
    void postToSocialMediaInstagram() {
        assert postToSocialMediaConditional.postToSocialMedia("instagram","a").equals("99");
        assert postToSocialMediaConditional.postToSocialMedia("instagram","b").equals("d");
    }

    @Test
    void postToSocialMediaTwitter(){
        System.out.println(postToSocialMediaConditional.postToSocialMedia("twitter", aLongString));
        assert postToSocialMediaConditional.postToSocialMedia("twitter", aLongString).equals("this abc");
    }
}