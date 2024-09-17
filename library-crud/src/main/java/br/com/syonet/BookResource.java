package br.com.syonet;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    // Listar livros com filtros opcionais
    @GET
    public List<Book> list(@QueryParam("title") String title, @QueryParam("author") String author, @QueryParam("year") Integer year) {
        if (title != null && !title.isEmpty()) {
            return Book.find("title like ?1", "%" + title + "%").list();
        }
        if (author != null && !author.isEmpty()) {
            return Book.find("author like ?1", "%" + author + "%").list();
        }
        if (year != null) {
            return Book.find("year", year).list();
        }
        return Book.listAll();
    }

    // Buscar livro pelo ID
    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") Long id) {
        Book book = Book.findById(id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(book).build();
    }

    // Criar novo livro
    @POST
    @Transactional
    public Response create(Book book) {
        book.persist();
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    // Atualizar um livro pelo ID
    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Book updatedBook) {
        Book book = Book.findById(id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        book.title = updatedBook.title;
        book.author = updatedBook.author;
        book.year = updatedBook.year;
        book.persist();
        return Response.ok(book).build();
    }

    // Deletar um livro
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Book book = Book.findById(id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        book.delete();
        return Response.noContent().build();
    }
}
