package com.groupal.libreriaPrismaBackend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsuarioRol is a Querydsl query type for UsuarioRol
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsuarioRol extends EntityPathBase<UsuarioRol> {

    private static final long serialVersionUID = 2059926063L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsuarioRol usuarioRol = new QUsuarioRol("usuarioRol");

    public final BooleanPath activo = createBoolean("activo");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QRol rol;

    public final QUsuario usuario;

    public QUsuarioRol(String variable) {
        this(UsuarioRol.class, forVariable(variable), INITS);
    }

    public QUsuarioRol(Path<? extends UsuarioRol> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsuarioRol(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsuarioRol(PathMetadata metadata, PathInits inits) {
        this(UsuarioRol.class, metadata, inits);
    }

    public QUsuarioRol(Class<? extends UsuarioRol> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.rol = inits.isInitialized("rol") ? new QRol(forProperty("rol")) : null;
        this.usuario = inits.isInitialized("usuario") ? new QUsuario(forProperty("usuario")) : null;
    }

}

