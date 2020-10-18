package com.groupal.libreriaPrismaBackend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 541837271L;

    public static final QBook book = new QBook("book");

    public final BooleanPath activo = createBoolean("activo");

    public final StringPath autor = createString("autor");

    public final StringPath descripcion = createString("descripcion");

    public final StringPath editorial = createString("editorial");

    public final StringPath genero = createString("genero");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nombre = createString("nombre");

    public final NumberPath<Integer> pages_number = createNumber("pages_number", Integer.class);

    public final NumberPath<Double> precio = createNumber("precio", Double.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}

