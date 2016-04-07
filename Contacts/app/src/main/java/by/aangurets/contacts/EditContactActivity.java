package by.aangurets.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import by.aangurets.contacts.model.Constants;
import by.aangurets.contacts.model.Contact;

public class EditContactActivity extends Activity {

    private Contact mContact;
    private int mContactPosition;

    @Bind(R.id.nameEditText)
    EditText mName;

    @Bind(R.id.surnameEditText)
    EditText mSurname;

    @Bind(R.id.phoneEditText)
    EditText mPhone;

    @Bind(R.id.emailAddressEditText)
    EditText mEmail;

    @Bind(R.id.dateEditText)
    EditText mDate;

    @Bind(R.id.occupationEditText)
    EditText mOccupation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_contact_activity);

        ButterKnife.bind(this);

        setTitle(R.string.edit_contact);
        mContactPosition = getIntent().getIntExtra(Constants.ID_SELECTED_CONTACT, 0);
        mContact = ContactsStorage.getAll().get(mContactPosition);
        fillingFields(mContact);
    }

    public void fillingFields(Contact contact) {
        mName.setText(contact.getName());
        mSurname.setText(contact.getSurname());
        mPhone.setText(contact.getPhone());
        mEmail.setText(contact.getEmail());
        mDate.setText(contact.getDateOfBirdth());
        mOccupation.setText(contact.getOccupation());
    }

    public void dubbingContact(Contact contact) {
        contact.setName(mName.getText().toString());
        contact.setSurname(mSurname.getText().toString());
        contact.setPhone(mPhone.getText().toString());
        contact.setEmail(mEmail.getText().toString());
        contact.setOccupation(mOccupation.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_contact:
                dubbingContact(mContact);
                Intent intent = new Intent(EditContactActivity.this, ContactListActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
