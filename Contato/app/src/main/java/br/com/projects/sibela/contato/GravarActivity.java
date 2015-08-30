package br.com.projects.sibela.contato;

import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.security.PublicKey;
import java.util.ArrayList;

import br.com.projects.sibela.bean.Item;
import br.com.projects.sibela.bean.Produto;


public class GravarActivity extends ActionBarActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtEndereco;
    private Button btnGravar;

    private static final String MY_IPV4 = "192.168.0.4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravar);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        btnGravar = (Button) findViewById(R.id.btnGravar);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://" + MY_IPV4 + ":8080/TesteMaster/cadastrarContato");

                try {

                    // Elements form screen as plaintext
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);

                    nameValuePairs.add(new BasicNameValuePair("nome", edtNome.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("email", edtEmail.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("endereco", edtEndereco.getText().toString()));

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpClient.execute(httpPost);

                    final HttpEntity entity = response.getEntity();

                    String resposta = EntityUtils.toString(entity);

                    Toast.makeText(getBaseContext(), resposta, Toast.LENGTH_LONG).show();





                    /*

                    // String json
                    Item item = new Item();

                    item.setIdItem(1);
                    item.setIdLista(1);
                    item.setQuantidade(3);
                    item.setChecado(false);

                    item.getProduto().setCodigoBarras("95320001");
                    item.getProduto().setNome("Maionese Hellman");
                    item.getProduto().setDecimal(false);

                    //passes the results to a string builder/entity
                    StringEntity stringEntity = new StringEntity(item.toStringJSON());

                    //sets the post request as the resulting string
                    httpPost.setEntity(stringEntity);

                    //sets a request header so the page receving the request
                    //will know what to do with it
                    httpPost.setHeader("Accept", "application/json");
                    httpPost.setHeader("Content-type", "application/json");

                    HttpResponse response = httpClient.execute(httpPost);

                    final HttpEntity entity = response.getEntity();

                    String resposta = EntityUtils.toString(entity);

                    Toast.makeText(getBaseContext(), resposta, Toast.LENGTH_LONG).show();

                    */


                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } /*catch (JSONException e) {
                    e.printStackTrace();
                } */
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gravar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
