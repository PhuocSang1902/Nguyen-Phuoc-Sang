import '../styles/globals.css'

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en">
      <head>
        <meta charSet="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="../styles/globals.css" rel="stylesheet" />
      </head>
      <body>{children}</body>
    </html>
  )
}
