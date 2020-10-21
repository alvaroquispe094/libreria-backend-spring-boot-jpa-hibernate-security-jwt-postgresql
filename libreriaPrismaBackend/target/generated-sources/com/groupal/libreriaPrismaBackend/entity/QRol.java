package com.groupal.libreriaPrismaBackend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRol is a Querydsl query type for Rol
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRol extends EntityPathBase<Rol> {

    private static final long serialVersionUID = 1957156641L;

    public static final QRol rol = new QRol("rol");

    public final BooleanPath activo = createBoolean("activo");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath rolNombre = createString("rolNombre");

    public QRol(String variable) {
        super(Rol.class, forVariable(variable));
    }

    public QRol(Path<? extends Rol> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRol(PathMetadata metadata) {
        super(Rol.class, metadata);
    }

}

