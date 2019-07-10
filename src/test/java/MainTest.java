import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.*;

class MainTest {


    private String aLongString = "this is a long string ";
    private PostToSocialMedia postToSocialMediaConditional = new PostToSocialMediaConditional();

    Set<PostToSocialMedia> postToSocialMediaList = new HashSet<>();

    @BeforeEach
    void setup(){
        postToSocialMediaList.add(new PostToSocialMediaConditional());
        postToSocialMediaList.add(new PostToSocialMediaConditionalExtractMethodPrep());
    }

    @Test
    void postToSocialMediaFacebook() {
        for(PostToSocialMedia postToSocialMedia : postToSocialMediaList){
            assert postToSocialMedia.postToSocialMedia("facebook","abc").equals("workedOKFacebook");
            assert postToSocialMedia.postToSocialMedia("facebook","1234d").equals("workedOKFacebook");
        }
    }

    @Test
    void postToSocialMediaInstagram() {
        for(PostToSocialMedia postToSocialMedia : postToSocialMediaList) {
            assert postToSocialMedia.postToSocialMedia("instagram", "a").equals("99");
            assert postToSocialMedia.postToSocialMedia("instagram", "b").equals("d");
        }
    }

    @Test
    void postToSocialMediaTwitter(){
        for(PostToSocialMedia postToSocialMedia : postToSocialMediaList) {
            assert postToSocialMediaConditional.postToSocialMedia("twitter", aLongString).equals("this abc");
        }
    }
}