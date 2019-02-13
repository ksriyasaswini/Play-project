package dao;

import models.UserDetails;
import play.db.jpa.JPAApi;

import javax.inject.Inject;

public class UserDaoImpl implements UserDao {

    final JPAApi jpaApi;

    @Inject
    public UserDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public UserDetails create (UserDetails userDetails) {

        if (null == userDetails) {
            throw new IllegalArgumentException("ID must be provided");
        }

        jpaApi.em().persist(userDetails);
        return userDetails;

    }

    public UserDetails update(UserDetails userDetails) {

        if (null == userDetails) {
            throw new IllegalArgumentException("Book must be provided");
        }

        if (null == userDetails.getId()) {
           throw new IllegalArgumentException("Book id must be provided");
        }

        final UserDetails existingUser = jpaApi.em().find(UserDetails.class, userDetails.getId());
        if (null == existingUser) {
            return null;
        }

            //existingBook.setTitle(book.getTitle());
            userDetails.setAccessToken(userDetails.getAccessToken());

            jpaApi.em().persist(userDetails);

            return userDetails;
        }


    @Override
    public UserDetails findUserByName(String username) {
        final UserDetails existingUser = jpaApi.em().find(UserDetails.class, username);
        if(null == existingUser) {
            return null;
        }
        return existingUser;
    }

    @Override
    public UserDetails findUserByAuthToken(String authToken) {
        return null;
    }
}
