package fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jiaofeng.sleep.R;
import com.gjiazhe.wavesidebar.WaveSideBar;
import com.gyf.barlibrary.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import adapter.ContactsAdapter;

/**
 * Created by jiaofeng on 2017/6/24.
 */

public class FriendFragment extends BaseFragment {
    private RecyclerView rvContacts;
    private WaveSideBar sideBar;
    private ArrayList<Contact> contacts = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_friend;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ImmersionBar.with(this).init();
        contacts.addAll(Contact.getChineseContacts());
        rvContacts = (RecyclerView) view.findViewById(R.id.rv_contacts);
        rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvContacts.setAdapter(new ContactsAdapter(contacts, R.layout.item_friendfragmentrecycleview));
        sideBar = (WaveSideBar) view.findViewById(R.id.side_bar);
        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                for (int i=0; i<contacts.size(); i++) {
                    if (contacts.get(i).getIndex().equals(index)) {
                        ((LinearLayoutManager) rvContacts.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ImmersionBar.with(this).destroy();
    }
    public static class Contact {
        private String index;
        private String name;

        public Contact(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public static List<Contact> getEnglishContacts() {
            List<Contact> contacts = new ArrayList<>();
            contacts.add(new Contact("A", "Abbey"));
            contacts.add(new Contact("A", "Alex"));
            contacts.add(new Contact("A", "Amy"));
            contacts.add(new Contact("A", "Anne"));
            contacts.add(new Contact("B", "Betty"));
            contacts.add(new Contact("B", "Bob"));
            contacts.add(new Contact("B", "Brian"));
            contacts.add(new Contact("C", "Carl"));
            contacts.add(new Contact("C", "Candy"));
            contacts.add(new Contact("C", "Carlos"));
            contacts.add(new Contact("C", "Charles"));
            contacts.add(new Contact("C", "Christina"));
            contacts.add(new Contact("D", "David"));
            contacts.add(new Contact("D", "Daniel"));
            contacts.add(new Contact("E", "Elizabeth"));
            contacts.add(new Contact("E", "Eric"));
            contacts.add(new Contact("E", "Eva"));
            contacts.add(new Contact("F", "Frances"));
            contacts.add(new Contact("F", "Frank"));
            contacts.add(new Contact("I", "Ivy"));
            contacts.add(new Contact("J", "James"));
            contacts.add(new Contact("J", "John"));
            contacts.add(new Contact("J", "Jessica"));
            contacts.add(new Contact("K", "Karen"));
            contacts.add(new Contact("K", "Karl"));
            contacts.add(new Contact("K", "Kim"));
            contacts.add(new Contact("L", "Leon"));
            contacts.add(new Contact("L", "Lisa"));
            contacts.add(new Contact("P", "Paul"));
            contacts.add(new Contact("P", "Peter"));
            contacts.add(new Contact("S", "Sarah"));
            contacts.add(new Contact("S", "Steven"));
            contacts.add(new Contact("R", "Robert"));
            contacts.add(new Contact("R", "Ryan"));
            contacts.add(new Contact("T", "Tom"));
            contacts.add(new Contact("T", "Tony"));
            contacts.add(new Contact("W", "Wendy"));
            contacts.add(new Contact("W", "Will"));
            contacts.add(new Contact("W", "William"));
            contacts.add(new Contact("Z", "Zoe"));
            return contacts;
        }

        public static List<Contact> getChineseContacts() {
            List<Contact> contacts = new ArrayList<>();
            contacts.add(new Contact("B", "白虎"));
            contacts.add(new Contact("C", "常羲"));
            contacts.add(new Contact("C", "嫦娥"));
            contacts.add(new Contact("E", "二郎神"));
            contacts.add(new Contact("F", "伏羲"));
            contacts.add(new Contact("G", "观世音"));
            contacts.add(new Contact("J", "精卫"));
            contacts.add(new Contact("K", "夸父"));
            contacts.add(new Contact("N", "女娲"));
            contacts.add(new Contact("N", "哪吒"));
            contacts.add(new Contact("P", "盘古"));
            contacts.add(new Contact("Q", "青龙"));
            contacts.add(new Contact("R", "如来"));
            contacts.add(new Contact("S", "孙悟空"));
            contacts.add(new Contact("S", "沙僧"));
            contacts.add(new Contact("S", "顺风耳"));
            contacts.add(new Contact("T", "太白金星"));
            contacts.add(new Contact("T", "太上老君"));
            contacts.add(new Contact("X", "羲和"));
            contacts.add(new Contact("X", "玄武"));
            contacts.add(new Contact("Z", "猪八戒"));
            contacts.add(new Contact("Z", "朱雀"));
            contacts.add(new Contact("Z", "祝融"));
            return contacts;
        }



    }
}
