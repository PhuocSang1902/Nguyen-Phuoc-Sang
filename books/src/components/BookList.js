import BookShow from './BookShow';
function BookList({ books, onDelete, onEdit }) {
  const renderedBooks = books.map((value) => {
    return (
      <BookShow
        key={value.id}
        book={value}
        onDelete={onDelete}
        onEdit={onEdit}
      />
    );
  });

  return <div className="book-list">{renderedBooks}</div>;
}

export default BookList;
