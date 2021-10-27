package jsonobjects.apiobjects;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@Getter
@Setter
public class Cat {

    private String name;
    @JsonDeserialize(as = ArrayList.class)
    private List<String> cats;

    // STASH CHANGES added
    // STASH CHANGES added
}
