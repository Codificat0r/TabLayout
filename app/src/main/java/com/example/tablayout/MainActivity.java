package com.example.tablayout;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewParent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * OPCION uno:
 * EN este ejercicio se ha visto como crear un tablayout de forma independiente al elemento ViewPager. Para ello
 * hay que implementar el listener en TabLayout y el listener en ViewPager y vincularlos de forma que se actualice el otro
 * elemento.
 */

/**
 * OPCION dos:
 * Vincular el tablayout al virewpager con el metodo setupWithViewPager().
 * Se debe cumplir unicamente el siguiente requisito: EL TITULO DE LAS PESTAÑAS DEL TAB SE INICIALIZAN MEDIANTE EL MÉTODO
 * getPageTitle().
 */

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabs;
    private TypedArray imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenes = getResources().obtainTypedArray(R.array.drawables);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Configurar TabLayout
        tabs = findViewById(R.id.tabs);
        //Permite movernos por las pestañas del tablayout, ya que habrá escondidas. Lo tipico en android
        //de arrastrar tabs.
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        //Añadir el título a las tabs mediante un array-string.
        for (String title : getResources().getStringArray(R.array.tabs)) {
            tabs.addTab(tabs.newTab().setText(title));
        }

        //OPCIÓN dos:

        //Configuramos el ViewPager
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), 5, new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.tabs)))));
        //Para animar el paso de una a otra: https://developer.android.com/training/animation/screen-slide.html#zoom-out
        //Animamos el paso de una pagina a otra en el ViewPager:
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        //Esto impide que se haga addTab, lo hace el viewPager las veces que le indiquemos en su constructor.
        //Si se quiere personalizar la pestañas dek tablayout se debe realizar despues del metodo setup
        tabs.setupWithViewPager(viewPager);
        setupTabIcons();

        //OPCION uno:

        /*tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Conectamos el viewpager y el tabs
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabs.setScrollPosition(position, positionOffset, true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }*/


        } //Fin onCreate

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupTabIcons() {
        for(int i = 0; i < imagenes.length(); i++) {
            tabs.getTabAt(i).setIcon(imagenes.getResourceId(i, 0));
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}
