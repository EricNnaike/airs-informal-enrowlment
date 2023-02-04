package com.app.AIRS.dto.filters;


import com.app.AIRS.entity.QSms;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

@Getter
@Setter
@NoArgsConstructor
public class SmsSearchFilter extends BaseSearchDto implements QuerydslBinderCustomizer<QSms> {
    @Override
    public void customize(QuerydslBindings bindings, QSms root) {
        bindings.bind(root.phoneNumber).as("phoneNumber").first((path, value) -> path.eq("+234"+value));
        bindings.bind(root.used).as("status").first((path, value) -> path.eq(value));
        bindings.including(root.phoneNumber, root.used);
    }
}
