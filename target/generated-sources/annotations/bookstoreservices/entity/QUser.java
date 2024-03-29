package bookstoreservices.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1815330530L;

    public static final QUser user = new QUser("user");

    public final DateTimePath<org.joda.time.DateTime> createdAt = createDateTime("createdAt", org.joda.time.DateTime.class);

    public final StringPath emailId = createString("emailId");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isActive = createBoolean("isActive");

    public final DateTimePath<org.joda.time.DateTime> loginAt = createDateTime("loginAt", org.joda.time.DateTime.class);

    public final NumberPath<Integer> loginCount = createNumber("loginCount", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath ssoType = createString("ssoType");

    public final DateTimePath<org.joda.time.DateTime> updatedAt = createDateTime("updatedAt", org.joda.time.DateTime.class);

    public final StringPath userType = createString("userType");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

