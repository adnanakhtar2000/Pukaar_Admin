package com.example.pukaaradmin.Adapters

import androidx.fragment.app.*

class TherapistList_Tab_Adapters(fragment_manager: FragmentManager ) : FragmentStatePagerAdapter(fragment_manager , BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var fragmentlist : ArrayList<Fragment> = ArrayList()
    var fragmenttitle : ArrayList<String> = ArrayList()
    override fun getCount(): Int {
        return fragmentlist.size
    }

    override fun getItem(position: Int): Fragment {
       return fragmentlist[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmenttitle[position]
    }
fun addfragment(fragment: Fragment , title : String){
    fragmentlist.add(fragment)
    fragmenttitle.add(title)
}

}