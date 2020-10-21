package com.groupal.libreriaPrismaBackend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRolOperacion is a Querydsl query type for RolOperacion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRolOperacion extends EntityPathBase<RolOperacion> {

    private static final long serialVersionUID = -583608073L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRolOperacion rolOperacion = new QRolOperacion("rolOperacion");

    public final BooleanPath activo = createBoolean("activo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOperacion operacion;

    public final NumberPath<Integer> orden = createNumber("orden", Integer.class);

    public final QRol rol;

    public QRolOperacion(String variable) {
        this(RolOperacion.class, forVariable(variable), INITS);
    }

    public QRolOperacion(Path<? extends RolOperacion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRolOperacion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRolOperacion(PathMetadata metadata, PathInits inits) {
        this(RolOperacion.class, metadata, inits);
    }

    public QRolOperacion(Class<? extends RolOperacion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.operacion = inits.isInitialized("operacion") ? new QOperacion(forProperty("operacion")) : null;
        this.rol = inits.isInitialized("rol") ? new QRol(forProperty("rol")) : null;
    }

}

