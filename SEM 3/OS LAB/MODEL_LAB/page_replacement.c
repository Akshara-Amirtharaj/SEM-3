#include<stdio.h>
#include<stdbool.h>

#define MAX_PAGES 100
#define MAX_FRAMES 10

int is_in_frame(int frames[],int page,int n_frames){
    for(int i=0;i<n_frames;i++){
        if(frames[i] ==page) return i;
    }
    return -1;
}

int fifo(int pages[MAX_PAGES],int n_pages,int n_frames){
    int frames[MAX_FRAMES]={-1};
    int page_fault=0,index=0;

    for(int i=0;i<n_pages;i++){
        int frame_index=is_in_frame(frames,pages[i],n_frames);
        if(frame_index==-1){
            frames[index]=pages[i];
            index=(index+1)%n_frames;
            page_fault++;
        }
    }
    return page_fault;
}

int lru(int pages[MAX_PAGES],int n_pages,int n_frames){
    int frames[MAX_FRAMES]={-1};
    int last_used[MAX_FRAMES]={0};
    int page_fault=0;
    int empty_index=0;

    for(int i=0;i<n_pages;i++){
        int frame_index=is_in_frame(frames,pages[i],n_frames);
        if(frame_index==-1){
            if(empty_index!=n_frames){
                frames[empty_index]=pages[i]; 
                last_used[empty_index]=i;
                empty_index++;
                
            }
            else{
            int lru_index=0;
            for(int j=0;j<n_frames;j++){
                if(last_used[j]<last_used[lru_index]) {lru_index=j;}
            }
            frames[lru_index]=pages[i];
            
            last_used[lru_index]=i;
        }
        page_fault++;
        }
        else{
            last_used[frame_index]=i;
        }
        
    }
    return page_fault;
}

int mru(int pages[MAX_PAGES],int n_pages,int n_frames){
    int frames[MAX_FRAMES]={-1};
    int most_used[MAX_FRAMES]={0};
    int page_fault=0;
    int empty_index=0;

    for(int i=0;i<n_pages;i++){
        int frame_index=is_in_frame(frames,pages[i],n_frames);
        if(frame_index==-1){
            if(empty_index!=n_frames){
                frames[empty_index]=pages[i];
                most_used[empty_index]=i;
                empty_index++;                
            }
            else{
            int mru_index=0;
            for(int j=0;j<n_frames;j++){
                if(most_used[j]>most_used[mru_index]) {mru_index=j;}
            }
            frames[mru_index]=pages[i];
            most_used[mru_index]=i;
        }
            page_fault++;
        }
        else{
            most_used[frame_index]=i;
        }
        
    }
    return page_fault;
}

int optimal(int pages[MAX_PAGES],int n_pages,int n_frames){

    int frames[MAX_FRAMES]={-1};
    
    int page_fault=0;
    int empty_index=0;
    for(int i=0;i<n_pages;i++){
        bool willcome[MAX_FRAMES]={false};
        int farthest=-1;
        int frame_index=is_in_frame(frames,pages[i],n_frames);
        if(frame_index==-1){
            page_fault++;

            if(empty_index<n_frames){
                frames[empty_index]=pages[i];
                empty_index++;
                
            }
            else{
            
            for(int j=0;j<n_frames;j++){
                willcome[j] = false;
                for(int k=i+1;k<n_pages;k++){
                    if(frames[j]==pages[k]){
                        willcome[j]=true;
                        if(j>farthest){
                            farthest=j;
                        }
                    }
                }
            }
            int flag=1;
            for(int w=0;w<n_frames;w++){
                if(!willcome[w]){
                    frames[w]=pages[i];
                    flag=0;
                    break;
                    
                }
            }
            if(flag){
                frames[farthest]=pages[i];

            }
            }
        }
    }
    return page_fault;
}

int main() {
    int pages[MAX_PAGES], n_pages, n_frames;

    printf("Enter number of pages: ");
    scanf("%d", &n_pages);

    printf("Enter the pages:\n");
    for (int i = 0; i < n_pages; i++) {
        scanf("%d", &pages[i]);
    }

    printf("Enter number of frames: ");
    scanf("%d", &n_frames);

    printf("FIFO Page Faults: %d\n", fifo(pages, n_pages, n_frames));
    printf("LRU Page Faults: %d\n", lru(pages, n_pages, n_frames));
    printf("MRU Page Faults: %d\n", mru(pages, n_pages, n_frames));
    printf("Optimal Page Faults: %d\n", optimal(pages, n_pages, n_frames));

    return 0;
}
