import java.time.Instant;

public class User implements Comparable<User> {
    private Long id;
    private Instant createdAt;
    private String name;
    private String username;
    private String email;
    private String password;
    private boolean emailVerified;
    private boolean isPrivate;

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.emailVerified = false;
        this.isPrivate = false;
        this.createdAt = Instant.now();
    }

    public User(Long id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isEmailVerified() { return emailVerified; }
    public void setEmailVerified(boolean emailVerified) { this.emailVerified = emailVerified; }

    public boolean isPrivate() { return isPrivate; }
    public void setPrivate(boolean isPrivate) { this.isPrivate = isPrivate; }

    public Instant getCreatedAt() { return createdAt; }

    @Override
    public int compareTo(User other) {
        if (other == null) {
            return 1;
        }
        
        if (this.username == null && other.username == null) {
            return 0;
        }
        if (this.username == null) {
            return -1;
        }
        if (other.username == null) {
            return 1;
        }
        
        return this.username.compareToIgnoreCase(other.username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return username != null ? username.equalsIgnoreCase(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.toLowerCase().hashCode() : 0;
    }
}
