package serializer;

class SWEngineer {

    private long id;
    private String name;
    private String[] languages;

    public SWEngineer(long id, String name, String[] languages) {
        this.id = id;
        this.name = name;
        this.languages = languages;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getLanguages() {
        return this.languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}