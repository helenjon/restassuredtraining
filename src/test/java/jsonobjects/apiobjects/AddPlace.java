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
public class AddPlace {

       @JsonDeserialize(keyAs= Location.class)
        private Location location;
        private Integer accuracy;
        private String name;
        private String phone_number;
        private String address;
        @JsonDeserialize(as = ArrayList.class)
        private List<String> types;
        private String website;
        private String language;
        }


