import org.junit.internal.runners.statements.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.*;

class MainTest {


    private String aLongString = "this is a long string ";

    Set<PostToSocialMedia> postToSocialMediaList = new HashSet<>();

    @BeforeEach
    void setup(){
        postToSocialMediaList.add(new PostToSocialMediaConditional());
        postToSocialMediaList.add(new PostToSocialMediaConditionalExtractedMethod());
        postToSocialMediaList.add(new PostToSocialMediaConditionalExtractObjects());
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
            assert postToSocialMedia.postToSocialMedia("twitter", aLongString).equals("this abc");
        }
    }

    @Test()
    void postToSocialMediaUnsupported(){
        for(PostToSocialMedia postToSocialMedia : postToSocialMediaList) {
            Exception e = null;
            try{
                postToSocialMedia.postToSocialMedia("not valid", aLongString);
            } catch (Exception e2){
                e = e2;
            }
            assert e instanceof UnsupportedOperationException;
        }
    }
}