package com.app.AIRS.dto.filters;


import com.app.AIRS.entity.userManagement.QPortalUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PortalUserSearchFilter extends BaseSearchDto implements QuerydslBinderCustomizer<QPortalUser> {
    private LocalDate createdAfter;
    private LocalDate createdBefore;

    @Override
    public void customize(QuerydslBindings bindings, QPortalUser root) {
        bindings.bind(root.status).as("status").first((path, value) -> path.eq(value));
        bindings.bind(root.email).as("email").first((path, value) -> path.eq(value));
        bindings.bind(root.firstName).as("firstName").first((path, value) -> path.equalsIgnoreCase(value));
        bindings.bind(root.lastName).as("lastName").first((path, value) -> path.equalsIgnoreCase(value));
        bindings.bind(root.role.name).as("role").first((path, value) -> path.equalsIgnoreCase(value));
        bindings.including(root.status, root.email, root.firstName, root.lastName, root.role.name);
    }
}
