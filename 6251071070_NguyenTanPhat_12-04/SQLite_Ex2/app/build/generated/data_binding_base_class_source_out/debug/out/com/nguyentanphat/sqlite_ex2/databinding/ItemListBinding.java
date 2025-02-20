// Generated by view binder compiler. Do not edit!
package com.nguyentanphat.sqlite_ex2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.nguyentanphat.sqlite_ex2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemListBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imvDelete;

  @NonNull
  public final ImageView imvEdit;

  @NonNull
  public final TextView txtInfor;

  private ItemListBinding(@NonNull LinearLayout rootView, @NonNull ImageView imvDelete,
      @NonNull ImageView imvEdit, @NonNull TextView txtInfor) {
    this.rootView = rootView;
    this.imvDelete = imvDelete;
    this.imvEdit = imvEdit;
    this.txtInfor = txtInfor;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imvDelete;
      ImageView imvDelete = ViewBindings.findChildViewById(rootView, id);
      if (imvDelete == null) {
        break missingId;
      }

      id = R.id.imvEdit;
      ImageView imvEdit = ViewBindings.findChildViewById(rootView, id);
      if (imvEdit == null) {
        break missingId;
      }

      id = R.id.txtInfor;
      TextView txtInfor = ViewBindings.findChildViewById(rootView, id);
      if (txtInfor == null) {
        break missingId;
      }

      return new ItemListBinding((LinearLayout) rootView, imvDelete, imvEdit, txtInfor);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
