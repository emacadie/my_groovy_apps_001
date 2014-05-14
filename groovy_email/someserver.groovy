import java.net.ServerSocket
def server = new ServerSocket( 4444 )
 
while ( true ) { 
    server.accept {  socket ->
        println "processing new connection..."
        socket.withStreams { input, output ->
            def reader = input.newReader()
            def buffer = reader.readLine()
            println "server received: $buffer"
            now = new Date()
            output << "echo-response($now): " + buffer + "\n"
        }
        println "processing/thread complete."
    }
}

/*
To use:
s = new Socket("localhost", 4444);
s.withStreams { input, output ->
  output << "echo testing ...\n"
  buffer = input.newReader().readLine()
  println "response = $buffer"
}

s3 = new Socket("localhost", 4444);
s3.withStreams { input, output ->
  output << "Love those Taiwan lay-deez ...\n"
  buffer = input.newReader().readLine()
  println "response = $buffer"
}

 */