package com.example.tal

import java.io.BufferedInputStream
import java.net.URL
import org.apache.http.util.ByteArrayBuffer
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import scala.io.Source
import android.widget.Toast


class MainActivity extends Activity {

  override def onCreate(bundle: Bundle) {

    super.onCreate(bundle);
    this.setContentView(R.layout.activity_main);

    val btn = findViewById(R.id.button1).asInstanceOf[Button]
    val txt = findViewById(R.id.editText1).asInstanceOf[EditText]
    var str = "Original"
    
    def read(url:String):String = io.Source.fromURL(url).mkString
    var downloadRun = new Runnable(){  
  
    	@Override
    	def run() = {  
    		// TODO Auto-generated method stub  
    		str = read("http://128.237.210.139:9999/getSuperNode/name1&12345&BB")
    	}
    }
    btn.setOnClickListener(new View.OnClickListener() {

      def onClick(v: View) = {
    	  txt setText str
    	  new Thread(downloadRun).start();
    	  Thread.sleep(10*1000)
    	  txt setText str
        //Toast.makeText(MainActivity.this, read("http://www.baidu.com"), 3000).show(); 
      }

    })
    
  }
    
}