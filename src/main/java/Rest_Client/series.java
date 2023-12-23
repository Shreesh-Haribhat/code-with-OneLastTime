package Rest_Client;

import java.net.URL;

public class series {
    int id;
    URL utl;
    String name;
    String type;
    String language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    public URL getUtl() {
        return utl;
    }

    public void setUtl(URL utl) {
        this.utl = utl;
    }
}
