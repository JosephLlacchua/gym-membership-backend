package com.ecommerce.platform.iam.domain.model.queries;

import  com.ecommerce.platform.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles roleName) {
}
