package lt.kauneta.edemocracy.auth.dto;

import lt.kauneta.edemocracy.auth.model.UserRole;

public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String role;
    private String roleName;

    public UserResponseDTO(Long id, String username, String email, UserRole role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role.name();
        this.roleName = role.getDisplayNameLt();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getRoleName() {
        return roleName;
    }
}
