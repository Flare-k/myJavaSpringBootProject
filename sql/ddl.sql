// USER TABLE
create table user (
                      id bigint generated by default as identity,
                      username VARCHAR(50),
                      password VARCHAR(100),
                      enabled BIT
                          primary key(id),
                      unique key(username)
            );

// ROLE TABLE
create table role(
                     id bigint generated by default as identity,
                     name VARCHAR(50),
                     primary key(id)
            );

// USER x ROLE MAPPING TABLE - USER_ROLE MANY-TO-MANY
create table user_role(
                          user_id bigint generated by default as identity,
                          role_id bigint generated by default as identity,
                          primary key(user_id, role_id),
                          foreign key (user_id) references user(id),
                          foreign key (role_id) references role(id)
                      );