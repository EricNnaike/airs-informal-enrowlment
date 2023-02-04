package com.app.AIRS.dto.filters;

import com.app.AIRS.entity.QProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;


@Getter
@Setter
@NoArgsConstructor
public class PropertySearchFilter extends BaseSearchDto implements QuerydslBinderCustomizer<QProperty> {
    private Long lga;

    @Override
    public void customize(QuerydslBindings bindings, QProperty root) {
        bindings.bind(root.area.id).as("area").first((path, value) -> path.eq(value));
        bindings.bind(root.street.id).as("street").first((path, value) -> path.eq(value));
        bindings.bind(root.type.id).as("type").first((path, value) -> path.eq(value));
        bindings.bind(root.category.id).as("category").first((path, value) -> path.eq(value));
        bindings. bind(root.pid).as("pid").first((path, value) -> path.eq(value));
        bindings.including(root.area, root.street, root.type, root.category, root.pid);
    }
}
