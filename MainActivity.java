package com.jessicathornsby.arcoredemo;

import android.app.Activity;
import android.app.ActivityManager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;

import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Material;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;


public class MainActivity extends AppCompatActivity {
//    private static final String TAG = MainActivity.class.getSimpleName();
//    private static final double MIN_OPENGL_VERSION = 3.0;
//
//    private ModelRenderable dinoRenderable;
//    private ArFragment arCoreFragment;
//
//
////    private String modelLink = "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Duck/glTF/Duck.gltf";
//
//    @RequiresApi(api = VERSION_CODES.N)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (!checkDevice((this))) {
//            return;
//        }
//
//        setContentView(R.layout.activity_main);
//        arCoreFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment);
//
//        if (Build.VERSION.SDK_INT >= VERSION_CODES.N) {
//
//            ModelRenderable.builder().setSource(MainActivity.this, RenderableSource.builder().setSource(MainActivity.this, Uri.parse(modelLink), RenderableSource.SourceType.GLTF2).build())
//                    .setRegistryId(modelLink)
//                    .build()
//                    .thenAccept(modelRenderable -> dinoRenderable = modelRenderable)
//                    .exceptionally(
//                            throwable -> {
//                                Log.e(TAG, "Unable to load renderable!!!!!!!!!!!");
//                                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
//                                return null;
//                            });
//
//
////            ModelRenderable.builder()
////                    .setSource(this, R.raw.dinosaur)
////                    .build()
////                    .thenAccept(renderable -> dinoRenderable = renderable)
////                    .exceptionally(
////                            throwable -> {
////                                Log.e(TAG, "Unable to load renderable");
////                                return null;
////                            });
//        }
//
//        arCoreFragment.setOnTapArPlaneListener(
//                (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
//                    if (dinoRenderable == null) {
//                        return;
//                    }
//
//                    Anchor anchor = hitResult.createAnchor();
//                    AnchorNode anchorNode = new AnchorNode(anchor);
//                    anchorNode.setParent(arCoreFragment.getArSceneView().getScene());
//
//                    TransformableNode transformableNode = new TransformableNode(arCoreFragment.getTransformationSystem());
//                    transformableNode.setParent(anchorNode);
//                    transformableNode.setRenderable(dinoRenderable);
//                    transformableNode.select();
//                });
//    }
//
//    public static boolean checkDevice(final Activity activity) {
//        if (Build.VERSION.SDK_INT < VERSION_CODES.N) {
//            Log.e(TAG, "Sceneform requires Android N or higher");
//            activity.finish();
//            return false;
//        }
//        String openGlVersionString =
//                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
//                        .getDeviceConfigurationInfo()
//                        .getGlEsVersion();
//        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
//            Log.e(TAG, "Requires OpenGL ES 3.0 or higher");
//            activity.finish();
//            return false;
//        }
//        return true;
//    }

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final double MIN_OPENGL_VERSION = 3.0;
    String SELECTED_IMG = "han1";
    private ModelRenderable dinoRenderable;
    private ArFragment arCoreFragment;
    //    int red = 128, gree = 0, blue = 255; //purpule
    int red = 255, gree = 0, blue = 0;
    Button iv1, iv2;

    AppCompatButton btnObj1, btnObj2, btnObj3, btnObj4;

    @RequiresApi(api = VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!checkDevice((this))) {
            return;
        }

        setContentView(R.layout.activity_main);

        btnObj1 = findViewById(R.id.btnObj1);
        btnObj2 = findViewById(R.id.btnObj2);
        btnObj3 = findViewById(R.id.btnObj3);
        btnObj4 = findViewById(R.id.btnObj4);

//        iv1 = (Button) findViewById(R.id.iv1);
//        iv2 = (Button) findViewById(R.id.iv2);
//        ModelRenderable.builder()
//                .setSource(MainActivity.this, R.raw.updated_file)
//                .build()
//                .thenAccept(renderable -> dinoRenderable = renderable)
//                .exceptionally(
//                        throwable -> {
//                            Log.e(TAG, "Unable to load renderable");
//                            return null;
//                        });


//        String modelLink = "https://github.com/yudiz-solutions/runtime_ar_android/raw/master/model/model.gltf";
//        String modelLink = "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Duck/glTF/Duck.gltf";

//          String modelLink = "https://bitbucket.org/pragnab/ar-object-move/raw/3390962a9fdbef76245239284b94b1a2a0b2a7a3/app/sampledata/duck_ypdated.gltf";
//            String modelLink = "https://foxtrotonlineportal.com/foxtrot_online/Duck.gltf";
//            String modelLink = "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Box/glTF/Box.gltf";
//            String modelLink = "https://raw.githubusercontent.com/remish-iipl/ar_demo/master/undefined.gltf";
//        String modelLink = "https://foxtrotonlineportal.com/foxtrot_online/pragna/scene.glb";
//        String modelLink = "https://foxtrotonlineportal.com/foxtrot_online/scene.glb";
//        String modelLink = "https://foxtrotonlineportal.com/foxtrot_online/pragna/Test%2022.gltf";
//        String modelLink = "https://github.com/remish-iipl/ar_demo/blob/master/test/scene.glb";
//        String modelLink = "https://raw.githubusercontent.com/remish-iipl/ar_demo/master/demo_tee.gltf";

        btnObj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnObj1.setTextColor(getResources().getColor(R.color.colorAccent));
                btnObj2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnObj3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnObj4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                String modelLink = "https://foxtrotonlineportal.com/foxtrot_online/pragna/ph_try.gltf";
                String extension = modelLink.substring(modelLink.lastIndexOf("."));
                object(modelLink, extension);
            }
        });

        btnObj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnObj1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnObj2.setTextColor(getResources().getColor(R.color.colorAccent));
                btnObj3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnObj4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                String modelLink = "https://foxtrotonlineportal.com/foxtrot_online/pragna/ph_try.glb";
                String extension = modelLink.substring(modelLink.lastIndexOf("."));
                object(modelLink, extension);
            }
        });

        btnObj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnObj1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnObj2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnObj3.setTextColor(getResources().getColor(R.color.colorAccent));
                btnObj4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                String modelLink = "https://foxtrotonlineportal.com/foxtrot_online/pragna/phone_try.glb";
                String extension = modelLink.substring(modelLink.lastIndexOf("."));
                object(modelLink, extension);
            }
        });

        btnObj4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnObj1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnObj2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnObj3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                btnObj4.setTextColor(getResources().getColor(R.color.colorAccent));
                String modelLink = "https://foxtrotonlineportal.com/foxtrot_online/pragna/scene.glb";
                String extension = modelLink.substring(modelLink.lastIndexOf("."));
                object(modelLink, extension);
            }
        });


//        ModelRenderable.builder()
//                .setSource(MainActivity.this, R.raw.pull_handle)
//                .build()
//                .thenAccept(renderable -> dinoRenderable = renderable)
//                .exceptionally(
//                        throwable -> {
//                            Log.e(TAG, "Unable to load renderable");
//                            return null;
//                        });
//        iv1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("diano!!!!");
//                iv1.setTextColor(getResources().getColor(R.color.colorAccent));
//                iv2.setTextColor(getResources().getColor(R.color.black));
//                Log.e("img ", "DIANO!!!! ");
//                CompletableFuture<Texture> futureTexture = Texture.builder()
//                        .setSource(MainActivity.this, R.drawable.logo)
//                        .build();
//
//                ModelRenderable.builder()
//                        .setSource(MainActivity.this, R.raw.pull_handle)
//                        .build()
//                        .thenAcceptBoth(futureTexture, (renderable, texture) -> {
//                            //  dinoRenderable = renderable;
//                            dinoRenderable.getMaterial().setTexture("baseColor", texture);
//                        })
//                        .exceptionally(
//                                throwable -> {
//                                    Toast.makeText(MainActivity.this, "Unable to load andy renderable", Toast.LENGTH_LONG).show();
//                                    return null;
//                                });
//            }
//        });
        /**https://github.com/google-ar/sceneform-android-sdk/issues/35*/
      /*  iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("not diano!!!");
                iv2.setTextColor(getResources().getColor(R.color.colorAccent));
                iv1.setTextColor(getResources().getColor(R.color.black));
                Log.e("img ", "NOT DIANO!!!! ");
                ModelRenderable.builder()
                        .setSource(MainActivity.this, R.raw.undefined)

                        .build()
                        .thenAccept(renderable -> dinoRenderable = renderable)
                        .exceptionally(
                                throwable -> {
                                    Log.e(TAG, "Unable to load renderable");
                                    return null;
                                });
            }
        });*/


        //ppppppppppppppppppp  SELECTED_IMG = Select_Img.img + "";
        arCoreFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment);

//        arCoreFragment.getArSceneView().getScene().getSunlight().setEnabled(true);


//        if (Build.VERSION.SDK_INT >= VERSION_CODES.N) {
//            ModelRenderable.builder()
//                    .setSource(this, R.raw.dinosaur)
//                    .build()
//                    .thenAccept(renderable -> dinoRenderable = renderable)
//                    .exceptionally(
//                            throwable -> {
//                                Log.e(TAG, "Unable to load renderable");
//                                return null;
//                            });
//        }

      /*  if (Build.VERSION.SDK_INT >= VERSION_CODES.N) {

            if (SELECTED_IMG.compareToIgnoreCase("han1") == 0) {
                ModelRenderable.builder()
                        .setSource(this, R.raw.dinosaur)
                        .build()
                        .thenAccept(renderable -> dinoRenderable = renderable)
                        .exceptionally(
                                throwable -> {
                                    Log.e(TAG, "Unable to load renderable");
                                    return null;
                                });
            }

            if (SELECTED_IMG.compareToIgnoreCase("han2") == 0) {
                ModelRenderable.builder()
                        .setSource(this, R.raw.new_f)
                        .build()
                        .thenAccept(renderable -> dinoRenderable = renderable)
                        .exceptionally(
                                throwable -> {
                                    Log.e(TAG, "Unable to load renderable");
                                    return null;
                                });
            }
            if (SELECTED_IMG.compareToIgnoreCase("han3") == 0) {
                ModelRenderable.builder()
                        .setSource(this, R.raw.new_file_second)
                        .build()
                        .thenAccept(renderable -> dinoRenderable = renderable)
                        .exceptionally(
                                throwable -> {
                                    Log.e(TAG, "Unable to load renderable");
                                    return null;
                                });
            }
        }*/
        try {
            arCoreFragment.setOnTapArPlaneListener(
                    (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
                        if (dinoRenderable == null) {
                            return;
                        }

                        Anchor anchor = hitResult.createAnchor();
                        AnchorNode anchorNode = new AnchorNode(anchor);
                        anchorNode.setParent(arCoreFragment.getArSceneView().getScene());

                        TransformableNode transformableNode = new TransformableNode(arCoreFragment.getTransformationSystem());
//
//                    transformableNode.getScaleController().setMaxScale(0.02f);
//                    transformableNode.getScaleController().setMinScale(0.01f);

                        Quaternion q1 = transformableNode.getLocalRotation();
                        Quaternion q2 = Quaternion.axisAngle(new Vector3(0f, 1f, 0f), -200f);
                        transformableNode.setLocalRotation(Quaternion.multiply(q1, q2));

                        transformableNode.getScaleController().setMaxScale(0.06f);
                        transformableNode.getScaleController().setMinScale(0.04f);


//                    Material material = transformableNode.getRenderable().getMaterial();
//                    material.setFloat(MaterialFactory.MATERIAL_METALLIC,1);
//                           // /* 0 or 1 for metallic */ );
//                    material.setFloat(MaterialFactory.MATERIAL_ROUGHNESS ,1);//* 0 to 1 */);

                        transformableNode.setParent(anchorNode);
                        transformableNode.setRenderable(dinoRenderable);
                        Material material = transformableNode.getRenderable().getMaterial();

                        //Material material = node.getRenderable().getMaterial();
                        // material.setFloat(MaterialFactory.MATERIAL_METALLIC, 0.63f);/* 0 or 1 for metallic */
                        ;
                        /// material.setFloat(MaterialFactory.MATERIAL_ROUGHNESS, 0.34f);///* 0 to 1 */);
                        //     material.setFloat(MaterialFactory.MATERIAL_REFLECTANCE, 0.34f);///* 0 to 1 */);

//                    material.setFloat(MaterialFactory.MATERIAL_COLOR,1);
////                    // /* 0 or 1 for metallic */ );
//                    material.setFloat(MaterialFactory.MATERIAL_ROUGHNESS ,1);//* 0 to 1 */);
////
//                    material.setFloat(MaterialFactory.MATERIAL_TEXTURE,2);

                        transformableNode.setOnTapListener(new Node.OnTapListener() {
                            @Override
                            public void onTap(HitTestResult hitTestResult, MotionEvent motionEvent) {
                                System.out.println("MotionEvent!!!!!!!!!!!!!!!@@@@ " + motionEvent.getAction() + "");
                                if (motionEvent.getAction() != MotionEvent.ACTION_UP) {
                                    return;
                                }

                                if (hitTestResult.getNode() != null) {
                                    transformableNode.select();
                                    Log.d(TAG, "handleOnTouch hitTestResult.getNode() != null");

                                    Node hitNode = hitTestResult.getNode();

                                    if (hitNode.getRenderable() == dinoRenderable) {
//                                    if (currentSelectedAnchorNode != null) {
//                                        currentSelectedAnchorNode.setRenderable(dinoRenderable);
//                                    }
                                        ModelRenderable highlightedAndyRenderable = dinoRenderable.makeCopy();
                                        //    highlightedAndyRenderable.getMaterial().setFloat3("baseColorTint", new Color(android.graphics.Color.rgb(red, gree, blue)));
//                                       highlightedAndyRenderable.getMaterial().setFloat3("baseColorTint", new Color(getResources().getColor(R.color.redlight)));

                                        hitNode.setRenderable(highlightedAndyRenderable);
                                        hitNode.setOnTapListener(new Node.OnTapListener() {
                                            @Override
                                            public void onTap(HitTestResult hitTestResult, MotionEvent motionEvent) {
                                                System.out.println("FINALLY THIS TOUCHED!!!!!!!!!!!!!!!!!!!!!!!");
                                                arCoreFragment.getArSceneView().getScene().removeChild(anchorNode);
                                                anchorNode.removeChild(hitNode);
                                                anchorNode.getAnchor().detach();
                                                hitNode.setParent(null);

                                            }
                                        });
                                    } else {
                                        System.out.println("this is issue regarding miss match!!!!!!!!!");
                                        if (hitNode.getRenderable() != null) {
                                            //  hitNode.getRenderable() = dinoRenderable.makeCopy()
                                            Renderable highlightedAndyRenderable = hitNode.getRenderable().makeCopy();
                                            // ModelRenderable highlightedAndyRenderable =hitResult
                                            //   highlightedAndyRenderable.getMaterial().setFloat3("baseColorTint", new Color(android.graphics.Color.rgb(red, gree, blue)));

                                            System.out.println("this is not null!!!!!!");
                                            hitNode.setRenderable(highlightedAndyRenderable);
                                            hitNode.setOnTapListener(new Node.OnTapListener() {
                                                @Override
                                                public void onTap(HitTestResult hitTestResult, MotionEvent motionEvent) {
                                                    System.out.println("FINALLY THIS TOUCHED!!!!!!!!!!!!!!!!!!!!!!!");
                                                    arCoreFragment.getArSceneView().getScene().removeChild(anchorNode);
                                                    anchorNode.removeChild(hitNode);
                                                    anchorNode.getAnchor().detach();
                                                    hitNode.setParent(null);

                                                }
                                            });
                                        } else {
                                            System.out.println("this is null!!!!!!!!!!!!!!");
                                        }
                                    }
                                }
                            }
                        });
                        transformableNode.select();
                    });
        } catch (Exception ex) {
            System.out.println("Exception :- " + ex.getMessage());
            Toast.makeText(this, "Exception:- " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public static boolean checkDevice(final Activity activity) {
        if (Build.VERSION.SDK_INT < VERSION_CODES.N) {
            Log.e(TAG, "Sceneform requires Android N or higher");
            activity.finish();
            return false;
        }
        String openGlVersionString =
                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Requires OpenGL ES 3.0 or higher");
            activity.finish();
            return false;
        }
        return true;
    }


    @RequiresApi(api = VERSION_CODES.N)
    void object(String modelLink, String extension) {
        try {
            if (extension.equalsIgnoreCase(".glb")) {
                ModelRenderable.builder().setSource(MainActivity.this, RenderableSource.builder().setSource(MainActivity.this, Uri.parse(modelLink), RenderableSource.SourceType.GLB).build())
                        .setRegistryId(modelLink)
                        .build()
                        .thenAccept(modelRenderable -> dinoRenderable = modelRenderable)
                        .exceptionally(
                                throwable -> {
                                    Log.e(TAG, "Unable to load renderable!!!!!!!!!!!");
                                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
                                    return null;
                                });
            } else if (extension.equalsIgnoreCase(".gltf")) {
                ModelRenderable.builder().setSource(MainActivity.this, RenderableSource.builder().setSource(MainActivity.this, Uri.parse(modelLink), RenderableSource.SourceType.GLTF2).build())
                        .setRegistryId(modelLink)
                        .build()
                        .thenAccept(modelRenderable -> dinoRenderable = modelRenderable)
                        .exceptionally(
                                throwable -> {
                                    Log.e(TAG, "Unable to load renderable!!!!!!!!!!!");
                                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
                                    return null;
                                });
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Toast.makeText(this, "Exception:- " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
