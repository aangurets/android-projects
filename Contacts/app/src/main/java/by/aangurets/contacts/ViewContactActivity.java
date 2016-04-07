package by.aangurets.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import by.aangurets.contacts.model.Constants;
import by.aangurets.contacts.model.Contact;

public class ViewContactActivity extends Activity {

    private int mContactPosition;

    @Bind(R.id.nameTextView)
    TextView mName;

    @Bind(R.id.surnameTextView)
    TextView mSurname;

    @Bind(R.id.phoneTextView)
    TextView mPhone;

    @Bind(R.id.emailAddressTextView)
    TextView mEmail;

    @Bind(R.id.dateTextView)
    TextView mDate;

    @Bind(R.id.occupationTextView)
    TextView mOccupation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact_activity);

        ButterKnife.bind(this);

        setTitle(R.string.review_contact);

        mContactPosition = getIntent().getIntExtra(Constants.ID_SELECTED_CONTACT, 0);
        Contact contact = ContactsStorage.getAll().get(mContactPosition);
        fillingFields(contact);
    }

    public void fillingFields(Contact contact) {
        mName.setText(contact.getName());
        mSurname.setText(contact.getSurname());
        mPhone.setText(contact.getPhone());
        mEmail.setText(contact.getEmail());
        mDate.setText(contact.getDateOfBirdth());
        mOccupation.setText(contact.getOccupation());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.review_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_contact:
                Intent intent = new Intent(ViewContactActivity.this, EditContactActivity.class);
                intent.putExtra(Constants.ID_SELECTED_CONTACT, mContactPosition);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
