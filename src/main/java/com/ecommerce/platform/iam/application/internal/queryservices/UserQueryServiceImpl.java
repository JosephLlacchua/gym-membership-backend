package com.ecommerce.platform.iam.application.internal.queryservices;

import  com.ecommerce.platform.iam.domain.model.aggregates.User;
import  com.ecommerce.platform.iam.domain.model.queries.GetAllUsersQuery;
import  com.ecommerce.platform.iam.domain.model.queries.GetUserByEmailQuery;
import  com.ecommerce.platform.iam.domain.model.queries.GetUserByIdQuery;
import  com.ecommerce.platform.iam.domain.services.UserQueryService;
import  com.ecommerce.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    /**
     * Constructor.
     *
     * @param userRepository {@link UserRepository} instance.
     */
    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method is used to handle {@link GetAllUsersQuery} query.
     * @param query {@link GetAllUsersQuery} instance.
     * @return {@link List} of {@link User} instances.
     * @see GetAllUsersQuery
     */
    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    /**
     * This method is used to handle {@link GetUserByIdQuery} query.
     * @param query {@link GetUserByIdQuery} instance.
     * @return {@link Optional} of {@link User} instance.
     * @see GetUserByIdQuery
     */
    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }




    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return userRepository.findByEmail(query.email());
    }
}
