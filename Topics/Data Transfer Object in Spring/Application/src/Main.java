import java.util.List;

class AuthorStatsDTO {
    private long id;
    private String name;
    private int blogsNumber;

    public AuthorStatsDTO() {
    }

    public AuthorStatsDTO(long id, String name, int blogsNumber) {
        this.id = id;
        this.name = name;
        this.blogsNumber = blogsNumber;
    }

    public AuthorStatsDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.blogsNumber = user.getBlogs().size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlogsNumber() {
        return blogsNumber;
    }

    public void setBlogsNumber(int blogsNumber) {
        this.blogsNumber = blogsNumber;
    }
}

class User {
    private long id;
    private String name;
    private String password;
    private List<Blog> blogs;

    //constructors, getters, and setters

    public User() {
    }

    public User(long id, String name, String password, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.blogs = blogs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}

class Blog {
    private long id;
    private String name;
    private User author;
    private String content;

    //constructors, getters, and setters
}